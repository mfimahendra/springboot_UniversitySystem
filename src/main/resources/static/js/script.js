function loadhead() {
    $("head").load("/layout/head.html");
}

$('#dropdownMenuButton').click(function () {
    $('.dropdown-menu').toggle()
});

$('.btn-toggle-desktop').click(function () {
    $('.sidebar').toggleClass('side-hide');
    $('.content-header').toggleClass('side-slide');
});

$('.btn-toggle-mobile').click(function () {
    $('.sidebar').addClass('side-show-mobile');
});

$('#hide-sidebar').click(function () {
    $('.sidebar').removeClass('side-show-mobile');
});