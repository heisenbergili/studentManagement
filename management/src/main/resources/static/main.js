$(document).ready(function () {
    console.log("Hello")

    $("#search").on("keyup", function () {
        filterByName();
    });

});

function filterByName() {
    const searchQuery = $("#search").val()
    
    // Send an AJAX GET request to the backend
    fetch(`/student/search?name=${encodeURIComponent(searchQuery)}`)
        .then(response => response.text()) // Expecting HTML from the server
        .then(html => {
            $("#students-table").html(html); // Update the results
        })
        .catch(error => console.error('Error:', error));
}