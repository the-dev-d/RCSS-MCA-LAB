<x-base-app>
    <x-navbar></x-navbar>
    <div class="container h-[80vh] mx-auto p-6">
        <h1>Hello from
            @foreach ( $names as $name )
            {{$name}},
            @endforeach
        </h1>
    </div>
    <x-footer></x-footer>
</x-base-app>