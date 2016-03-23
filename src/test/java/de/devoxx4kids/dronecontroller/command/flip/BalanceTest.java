package de.devoxx4kids.dronecontroller.command.flip;

import de.devoxx4kids.dronecontroller.command.Acknowledge;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

import static org.hamcrest.MatcherAssert.assertThat;


/**
 * Unit test of {@link Balance}.
 *
 * @author  Tobias Schneider
 */
public class BalanceTest {

    private Balance sut;

    @Before
    public void setUp() throws Exception {

        sut = Balance.balance();
    }


    @Test
    public void getBytes() {

        byte[] bytesPackage = sut.getPacket(1);

        assertThat(bytesPackage, is(new byte[] { 4, 11, 1, 15, 0, 0, 0, 3, 0, 1, 0, 0, 0, 0, 0 }));
    }


    @Test
    public void testToString() {

        assertThat(sut.toString(), is("Balance"));
    }


    @Test
    public void getAcknowledge() {

        Acknowledge acknowledge = sut.getAcknowledge();

        assertThat(acknowledge, is(Acknowledge.AckBefore));
    }


    @Test
    public void waitingTime() {

        int waitingTime = sut.waitingTime();

        assertThat(waitingTime, is(500));
    }
}
