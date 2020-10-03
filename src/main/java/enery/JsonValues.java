package enery;

import java.time.Instant;

public class JsonValues {

    private String appliedMethod;
    private Instant timestamp;
    private Float v_1_8_0;
    private Float v_1_8_1;
    private Float v_1_8_2;
    private Float v_2_8_0;
    private Float power;
    private String serverID;
    private Integer secindex;

    public String getServerID() {
        return serverID;
    }

    public void setServerID(String serverID) {
        this.serverID = serverID;
    }

    public Integer getSecindex() {
        return secindex;
    }

    public void setSecindex(Integer secindex) {
        this.secindex = secindex;
    }

    public Float getV_1_8_0() {
        return v_1_8_0;
    }

    public void setV_1_8_0(Float v_1_8_0) {
        this.v_1_8_0 = v_1_8_0;
    }

    public Float getV_1_8_1() {
        return v_1_8_1;
    }

    public void setV_1_8_1(Float v_1_8_1) {
        this.v_1_8_1 = v_1_8_1;
    }

    public Float getV_1_8_2() {
        return v_1_8_2;
    }

    public void setV_1_8_2(Float v_1_8_2) {
        this.v_1_8_2 = v_1_8_2;
    }

    public Float getV_2_8_0() {
        return v_2_8_0;
    }

    public void setV_2_8_0(Float v_2_8_0) {
        this.v_2_8_0 = v_2_8_0;
    }

    public Float getPower() {
        return power;
    }

    public void setPower(Float power) {
        this.power = power;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    public String getAppliedMethod() {
        return appliedMethod;
    }

    public void setAppliedMethod(String appliedMethod) {
        this.appliedMethod = appliedMethod;
    }




}
