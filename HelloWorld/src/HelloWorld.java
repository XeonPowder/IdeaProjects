public class HelloWorld {
    private String message;
    public HelloWorld(String m) {
        message = new String((m == null) ? "Hello World!" : m);
    }
    public String getMessage() {return this.message; }
}
