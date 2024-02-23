<?php

use Illuminate\Support\Facades\Route;
use App\Http\Controllers\FirstController;

Route::get('/', function () {
    return view('welcome');
});
Route::get('/home', [FirstController::class, 'home']);