<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;

class FirstController extends Controller
{
    //

    public function home() {

        $names = ["Dhaivath Lal", "The-Dev-D"];
        return view('home', ['names' => $names]);
    }
}
