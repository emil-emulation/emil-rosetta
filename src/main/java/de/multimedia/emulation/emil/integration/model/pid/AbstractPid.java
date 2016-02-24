package de.multimedia.emulation.emil.integration.model.pid;

/**
 * Share pid storage, equals and hashCode for identity between different identifier classes.
 */
public abstract class AbstractPid implements Pid {

    private final String pid;

    public AbstractPid(String pid) {
        if (pid == null) {
            throw new IllegalArgumentException("Pid must not be null.");
        }
        if ("".equals(pid)) {
            throw new IllegalArgumentException("Pid must not be empty.");
        }
        this.pid = pid;
    }

    @Override
    public String getPid() {
        return pid;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Pid) {
            AbstractPid abstractPid = (AbstractPid) obj;
            return pid.equals(abstractPid.pid);
        }
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return pid.hashCode();
    }

}
