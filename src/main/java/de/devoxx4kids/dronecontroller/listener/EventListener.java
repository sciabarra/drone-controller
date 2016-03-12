package de.devoxx4kids.dronecontroller.listener;

/**
 * @author  Alexander Bischof
 * @author  Tobias Schneider
 */
public interface EventListener {

    /**
     * Tries to consume the given data packet.
     *
     * @param  data  to consume
     */
    void consume(byte[] data);


    /**
     * @param  data
     *
     * @return  true if the packet could be consumed, false otherwise
     */
    boolean test(byte[] data);


    default boolean filterProject(byte[] data, int project, int clazz, int cmd) {

        return data[7] == project && data[8] == clazz && data[9] == cmd;
    }
}
