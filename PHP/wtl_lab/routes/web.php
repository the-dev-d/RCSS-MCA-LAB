<?php

use Illuminate\Http\Request;
use Illuminate\Support\Facades\Route;
use Illuminate\Support\Facades\Validator;

Route::get('/', function () {
    return view('welcome');
});

Route::get('/home', function () {
    return view('home');
});
Route::get('/login', function () {
    return view('login');
})->name('login');
Route::post('/login', function (Request $request) {

    $validated = Validator::make($request->all(), [
        'email' => 'required|email',
        'password' => 'required|min:6',
    ])->validate();

    if ($validated) {
        return redirect('/home');
    } else {
        return redirect('/login')->withErrors($validated);
    }
});