<x-baseapp>
    <div class="w-screen h-screen bg-gradient-to-tr from-emerald-200 to-blue-100 grid place-items-center">
        <div class="p-6 bg-white rounded-md shadow-md">
            @auth
                <h1 class="text-xl font-semibold">Welcome, {{ auth()->user()->name }}</h1>
            @endauth
        </div>
    </div>
</x-baseapp>