<?php

namespace App\Http\Controllers;

use App\Models\Blog;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Auth;

class BlogController extends Controller
{
    function index() {
        $blogs = Blog::all();
        return view('blogs', ['blogs' => $blogs]);
    }

    function create() {
        return view('blog-add');
    }

    function edit($id) {
        $blog = Blog::find($id);
        return view('blog-edit', ['blog' => $blog, 'id' => $id]);
    }

    function update(Request $request, $id) {
        $validated = $request->validate([
            'title' => 'required',
            'description' => 'required'
        ]);

        $blog = Blog::find($id);
        $blog->title = $validated['title'];
        $blog->content = $validated['description'];
        $blog->save();
        return redirect('blogs')->with('success', 'Blog has been successfully updated');
    }

    function save(Request $request) {
        $request->validate([
            'title' => 'required',
            'description' => 'required'
        ]);

        $blog = new Blog();
        $blog->title = $request->title;
        $blog->content = $request->description;
        $blog->user_id = Auth::user()->id;
        $blog->save();
        return redirect('blogs')->with('success', 'Blog has been successfully added');
    }

    function delete($id) {
        $blog = Blog::find($id);
        $blog->delete();
        return redirect('blogs')->with('success', 'Blog has been successfully deleted');
    }
}
