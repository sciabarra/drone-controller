package de.devoxx4kids.dronecontroller.command.multimedia;

import de.devoxx4kids.dronecontroller.command.ChannelType;
import de.devoxx4kids.dronecontroller.command.Command;
import de.devoxx4kids.dronecontroller.command.CommandKey;
import de.devoxx4kids.dronecontroller.command.PacketType;

import static de.devoxx4kids.dronecontroller.command.PacketType.DATA_WITH_ACK;


/**
 * Audio theme command.
 *
 * <p>Responsible for the selection of the audio theme</p>
 *
 * @author  Alexander Bischof
 * @author  Tobias Schneider
 */
public final class AudioTheme implements Command {

    public enum Theme {

        Default,
        Robot,
        Insect,
        Monster;
    }

    private final PacketType packetType = DATA_WITH_ACK;
    private final CommandKey commandKey = CommandKey.commandKey(3, 12, 1);
    private final Theme theme;

    private AudioTheme(AudioTheme.Theme theme) {

        this.theme = theme;
    }

    public static AudioTheme audioTheme(AudioTheme.Theme theme) {

        return new AudioTheme(theme);
    }


    @Override
    public byte[] getPacket(int sequenceNumber) {

        return new byte[] {
                packetType.toByte(), ChannelType.JUMPINGSUMO_CONTROLLER_TO_DEVICE_ACK_ID.toByte(),
                (byte) sequenceNumber, 15, 0, 0, 0, commandKey.getProjectId(), commandKey.getClazzId(),
                commandKey.getCommandId(), 0, (byte) theme.ordinal(), 0, 0, 0
            };
    }


    @Override
    public PacketType getPacketType() {

        return packetType;
    }


    @Override
    public String toString() {

        return "AudioTheme{"
            + "theme=" + theme + '}';
    }
}
