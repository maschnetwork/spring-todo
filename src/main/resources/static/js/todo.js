function formToJSON(form) {
    const formArray = $(form).serializeArray()
    var returnArray = {};
    for (var i = 0; i < formArray.length; i++){
        returnArray[formArray[i]['name']] = formArray[i]['value'];
    }
    return JSON.stringify(returnArray);
}

$("#todo-form").submit(function(e) {
    var url = "/todo";
    $.ajax({
        type: "POST",
        url: url,
        contentType: "application/json",
        data: formToJSON($("#todo-form")),
        success: function() {
            $("#todo-form").trigger("reset");
            M.toast({html: "Todo created"});
        }
    });

    e.preventDefault();
});

