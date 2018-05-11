function formToJSON(form) {
    const formArray = $(form).serializeArray()
    var returnArray = {};
    for (var i = 0; i < formArray.length; i++){
        returnArray[formArray[i]['name']] = formArray[i]['value'];
    }
    return JSON.stringify(returnArray);
}

function createTodo(e) {
    $.ajax({
        type: "POST",
        url: "/todo",
        contentType: "application/json",
        data: formToJSON($("#todo-form")),
        success: function() {
            $("#todo-form").trigger("reset");
            M.toast({html: "Todo created"});
        }
    });
    e.preventDefault();
};

function setTodoToDone () {
    var el = $(this);
    var todoId = el.data('id');
    $.ajax({
        type: "PUT",
        url: "/todo/"+todoId+"/status",
        contentType: "application/json",
        data: JSON.stringify({done: el.prop("checked")}),
        success: function() {
            M.toast({html: "Todo updated"});
        }
    });
}

function deleteTodo() {
    var el = $(this);
    var todoId = el.data('id');
    $.ajax({
        type: "DELETE",
        url: "/todo/"+todoId,
        data: "",
        success: function() {
            M.toast({html: "Todo deleted"});
            window.location.href = "/todos";
        },
        error: function(err){
            console.log(err);
        }
    });
};

function updateTodo(e) {
    var todoID = $("#todo-id").val();
    $.ajax({
        type: "PUT",
        url: "/todo/"+todoID,
        contentType: "application/json",
        data: formToJSON($("#todo-update-form")),
        success: function() {
            M.toast({html: "Todo updated"});
            window.location.href = "/todos";
        }
    });
    e.preventDefault();
};



$(document).ready(function() {
    $(document).on('change', '.done-checkbox', setTodoToDone);
    $(document).on('click', '#delete-todo', deleteTodo);
    $(document).on('submit', '#todo-form', createTodo);
    $(document).on('submit', '#todo-update-form', updateTodo);
});


