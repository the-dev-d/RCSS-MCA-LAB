<x-baseapp>
    <div class="w-screen h-screen bg-gradient-to-tr from-emerald-200 to-blue-100 grid place-items-center">
        <div class="w-11/12 bg-white rounded-lg shadow-lg p-8">
            <h1 class="text-3xl font-bold">Add Blog</h1>
            <form class="grid grid-rows-[min-content_1fr] h-3/4 gap-3" action="{{ route('blog.store.post') }}" method="POST" class="mt-4">
                @csrf

                <div class="">
                    <label for="title" class="block text-sm font-medium text-gray-900 dark:text-white">Your title</label>
                    <input name="title" type="text" id="title" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5" placeholder="Title of blog" required />
                </div>
                
                <div class="w-full h-full mx-auto">
                    <textarea name="description" id="description" rows="4" class="block h-full p-2.5 w-full text-sm text-gray-900 bg-gray-50 rounded-lg border border-gray-300 focus:ring-blue-500 focus:border-blue-500" placeholder="Leave a comment..."></textarea>
                </div>
                @error('title')
                    <div class="text-red-500 text-sm">{{ $message }}</div>    
                @enderror
                @error('description')
                    <div class="text-red-500 text-sm">{{ $message }}</div>
                @enderror
                <button class="w-full p-2 bg-emerald-300 rounded-md text-white font-semibold">
                    Post
                </button>
            </form>
        </div>
    </div>
</x-baseapp>