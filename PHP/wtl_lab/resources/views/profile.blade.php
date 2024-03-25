<x-baseapp>
    <div class="w-screen h-screen bg-gradient-to-tr from-emerald-200 to-blue-100 grid place-items-center content-center gap-3">
        <div class=" bg-emerald-200 w-1/2 grid grid-cols-2">
            <a class="p-3 bg-cyan-300 text-center" href="profile">Profile</a>
            <a class="p-3 bg-cyan-400 text-center" href="subjects">Subjects</a>
        </div>
        <div class="bg-white p-6 w-1/2 grid gap-6">
            @auth
        <div>
            <span>Name : </span>
            <span>{{ auth()->user()->first_name . " " . auth()->user()->last_name }}</span>
        </div>
        <div>
            <span>Email : </span>
            <span>{{ auth()->user()->email }}</span>
        </div>
        <div>
            <span>Created at : </span>
            <span>{{ auth()->user()->created_at }}</span>
        </div>
        <div>
            <span>Updated at : </span>
            <span>{{ auth()->user()->updated_at }}</span>
        </div>
        <div>
            <span>Email : </span>
            <span>{{ auth()->user()->email }}</span>
        </div>
        <div>
            <span>Roll No : </span>
            <span>{{ auth()->user()->roll_no }}</span>
        </div>
    @endauth
        </div>
    </div>
</x-baseapp>