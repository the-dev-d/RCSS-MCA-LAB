<?php

use App\Http\Controllers\BlogController;
use App\Models\User;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Auth;
use Illuminate\Support\Facades\Route;
use Illuminate\Support\Facades\Validator;

Route::get('/', function () {
    return view('welcome');
});



Route::get('/login', function () {
    return view('login');
})->name('login');

Route::group(['middleware' => 'auth'], function () {
    Route::get('/home', function () {
        return view('home');
    })->middleware('auth');

    Route::get('/blogs', [BlogController::class, 'index'])->name('blogs');
    Route::get('/blogs/create', [BlogController::class, 'create'])->name('blogs.store.get');
    Route::post('/blogs', [BlogController::class, 'save'])->name('blog.store.post');
    Route::get('/blogs/edit/{id}', [BlogController::class, 'edit'])->name('blog.edit.get');
    Route::post('/blogs/update/{id}', [BlogController::class, 'update'])->name('blog.update');
    Route::delete('/blogs/delete/{id}', [BlogController::class, 'delete'])->name('blog.delete');
});

Route::post('/login', function (Request $request) {

    $validated = Validator::make($request->all(), [
        'email' => 'required|email',
        'password' => 'required|min:6',
    ])->validate();

    if ($validated) {
        if(Auth::attempt($validated)){
            return redirect('/home');
        }
        else {
            return redirect('/login')->withErrors(['email' => 'Invalid email or password']);
        }
    } else {
        return redirect('/login')->withErrors($validated);
    }
});


Route::get('/register', function () {

    return view('register');
    
});

Route::post('/register', function (Request $request) {

    $validated = Validator::make($request->all(), [
        'email' => 'required|email',
        'password' => 'required|min:6',
        'confirm' => 'required',
        'name' => 'required',
    ])->validate();

    if ($validated['password'] != $validated['confirm']) {
        return redirect('/register')->withErrors(['confirm' => 'Password and Confirm Password must be same']);
    }

    if ($validated) {

        $user  = new User();
        $user->name = $validated['name'];
        $user->email = $validated['email'];
        $user->password = $validated['password'];
        $user->save();
        return redirect('/home');
    } else {
        return redirect('/register')->withErrors($validated);
    }
})->name('register');