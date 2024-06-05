<?php

use App\Http\Controllers\BlogController;
use App\Models\Student;
use App\Models\Subject;
use App\Models\User;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Auth;
use Illuminate\Support\Facades\Route;
use Illuminate\Support\Facades\Validator;

Route::get('/', function () {
    return view('welcome');
});

Route::get('/register', function () {
    return view('register');
});
Route::get('/login', function () {
    return view('login');
});
Route::post('/register', function () {
    
    $validator = Validator::make(request()->all(), [
        'first_name' => 'required',
        'last_name' => 'required',
        'email' => 'required|email',
        'password' => 'required',
        'confirm' => 'required|same:password',
    ]);
    
    if ($validator->fails()) {
        return redirect('/register')
            ->withErrors($validator)
            ->withInput();
    }
    
    $student = new Student();
    $student->first_name = request('first_name');
    $student->last_name = request('last_name');
    $student->email = request('email');
    $student->password = bcrypt(request('password'));
    $student->roll_no = rand(1000, 9999);
    $student->save();
        
    return redirect('/');
})->name('register.post');

Route::post('/login', function () {
    
    $validator = Validator::make(request()->all(), [
        'email' => 'required|email',
        'password' => 'required',
    ]);
    
    if ($validator->fails()) {
        return redirect('/login')
            ->withErrors($validator)
            ->withInput();
    }
    
    $credentials = request()->only('email', 'password');
    
    if (Auth::guard('student')->attempt($credentials)) {
        return redirect('/');
    }
    else {
        return redirect('/login')
            ->withErrors([
                'email' => 'The provided credentials do not match our records.',
            ])
            ->withInput();
    }
    
    return redirect('/login');
})->name('login.post');

Route::group(['middleware' => 'auth:student'], function () {
    Route::get('/profile', function () {
        return view('profile');
    });
    Route::get('/subjects', function () {
        $subjects = Subject::all();
        return view('subjects', ['subjects' => $subjects]);
    });
});