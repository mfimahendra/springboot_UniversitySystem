$(document).ready(function () {
    $('#sidebar').load("/sidebar.html");        
});

$('#dropdownMenuButton').click(function () {
    $('.dropdown-menu').toggle()
});

$('.btn-toggle-desktop').click(function () {
    $('.sidebar').toggleClass('side-hide');
    $('.content').toggleClass('side-slide');
    $('.content-header').toggleClass('side-slide');
});

$('.btn-toggle-mobile').click(function () {
    $('.sidebar').addClass('side-show-mobile');
});

$('#hide-sidebar').click(function () {
    $('.sidebar').removeClass('side-show-mobile');
});

function searchAdmin() {
    var input, filter, table, tr, td, i, txtValue;
    input = document.getElementById("search");
    filter = input.value.toUpperCase();
    table = document.getElementsByClassName("table")[0];
    tr = table.getElementsByTagName("tr");
    for (i = 0; i < tr.length; i++) {
        td = tr[i].getElementsByTagName("td")[1];
        if (td) {
            txtValue = td.textContent || td.innerText;
            if (txtValue.toUpperCase().indexOf(filter) > -1) {
                tr[i].style.display = "";
            } else {
                tr[i].style.display = "none";
            }
        }
    }
}