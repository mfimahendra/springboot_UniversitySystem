function getStudent() {
    $.ajax({
        type: "get",
        url: "url",
        data: "array",
        dataType: "json",
        success: function (response) {                
            console.log(response);
        }
    });
}