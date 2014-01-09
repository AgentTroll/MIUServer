package info.mineinunity.miuserver.protocol.auth;

import java.io.Serializable;

public class Client implements Serializable {
    private static final long serialVersionUID = -7045913813827343817L;

    private final String name;

    public Client(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
