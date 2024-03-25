<x-baseapp>
    <div class="w-screen h-screen bg-gradient-to-tr from-emerald-200 to-blue-100 grid place-items-center">
        <div class="w-11/12 bg-white rounded-lg shadow-lg p-8">
            <h1 class="text-3xl font-bold">Blogs 
            <a class="font-medium" href="blogs/create">+</a>    
            </h1>
            <div class="grid grid-cols-1 gap-4 mt-4">
                @foreach ($blogs as $blog)
                    <div class=" p-4 rounded-lg border-2">
                        <h2 class="text-xl font-semibold mb-2">
                            {{ $blog->title }}
                            <a class="text-gray-400 text-base font-medium underline ml-3" href="blogs/edit/{{  $blog->id }}">Edit</a>
                            <a class="text-gray-400 text-base font-medium underline ml-3" href="blogs/delete/{{  $blog->id }}">Delete</a>
                        </h2>
                        <p class="text-gray-600">{{ $blog->content }}</p>
                    </div>
                @endforeach
            </div>
        </div>
    </div>
</x-baseapp>