$(function() {

    $('#side-menu').metisMenu();

});

//Loads the correct sidebar on window load
$(function() {

    $(window).bind("load", function() {
        console.log($(this).width());
        if ($(this).width() < 768) {
            $('div.sidebar-collapse').addClass('collapse');
            $('body').css('margin-top','100px');
        } else {
            $('div.sidebar-collapse').removeClass('collapse');
            $('body').css('margin-top','50px');
        }
    });
});

//Collapses the sidebar on window resize
$(function() {

    $(window).bind("resize", function() {
        console.log($(this).width());
        if ($(this).width() < 768) {
            $('div.sidebar-collapse').addClass('collapse');
            $('body').css('margin-top','100px');
        } else {
            $('div.sidebar-collapse').removeClass('collapse');
            $('body').css('margin-top','50px');
        }
    });
});
