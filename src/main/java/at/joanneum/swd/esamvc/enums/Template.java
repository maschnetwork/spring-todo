package at.joanneum.swd.esamvc.enums;

public enum Template {

    TODO_CREATE("todo_create"),
    TODO_DETAIL("todo_detail"),
    TODO_LIST("todos");

    private final String name;

    Template(String url) {
        this.name = url;
    }

    public String getName() {
        return name;
    }
}
