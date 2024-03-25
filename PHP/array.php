<?php


?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Arrays</title>
    <style>
        body {
            font-family: Poppins, sans-serif;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background-color: rgb(181, 247, 211);
        }
        .container {
            background-color: #fff;
            padding: 1rem;
            border-radius: 0.5rem;
            width: 80%;
            height: 80vh;
            display: grid;
            align-items: center;
            display: grid;
            grid-template-columns: 1fr 1fr;
        }
        .container div {
            padding: 2rem;
        }
        ul {
            display: flex;
            list-style-type: none;  
            padding: 0rem;
            gap: 0.7rem;
        }
    </style>
</head>
<body>
    <div class="container">
        <div>
            <?php 
                $array = array("Tony", "Steve", "Bruce", "Natasha", "Clint", "Thor", "Wanda", "Vision", "Peter", "Carol", "Tony", "Steve");
                echo "<h1>Avengers</h1>";
                echo "<ul>";
                foreach($array as $name) {
                    echo "<li>$name</li>";
                }
                echo "</ul>";
            ?>
        </div>
        <div>
            <?php 
                sort($array);
                echo "<h1>Sorted Avengers</h1>";
                echo "<ul>";
                foreach($array as $name) {
                    echo "<li>$name</li>";
                }
                echo "</ul>";
            ?>
        </div>
        <div>
            <?php 
                $array = array_unique($array);
                echo "<h1>Non duplicate Avengers</h1>";
                echo "<ul>";
                foreach($array as $name) {
                    echo "<li>$name</li>";
                }
                echo "</ul>";
            ?>
        </div>
        <div>
            <?php 
                array_pop($array);
                echo "<h1>Last removed Avengers</h1>";
                echo "<ul>";
                foreach($array as $name) {
                    echo "<li>$name</li>";
                }
                echo "</ul>";
            ?>
        </div>
        <div>
            <?php 
                $array = array_reverse($array);
                echo "<h1>Reversed Avengers</h1>";
                echo "<ul>";
                foreach($array as $name) {
                    echo "<li>$name</li>";
                }
                echo "</ul>";
            ?>
        </div>
        <div>
            <?php 
                //search for tony and display index
                $index = array_search("Tony", $array);
                echo "<h1>Search Tony</h1>";
                echo "<p>Index: $index</p>";
            ?>
        </div>
    </div>
</body>
</html>