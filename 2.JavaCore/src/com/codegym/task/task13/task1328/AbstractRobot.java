package com.codegym.task.task13.task1328;

public abstract class AbstractRobot implements CanAttack, CanDefend{
    private static int hitCount;
    private static String name;

    public AbstractRobot(String name) {
        AbstractRobot.name = name;
    }

    public String getName() {
        return name;
    }

    public BodyPart attack() {
        BodyPart attackedBodyPart = null;
        hitCount = hitCount + 1;

        if (hitCount == 1) {
            attackedBodyPart = BodyPart.ARM;
        } else if (hitCount == 2) {
            attackedBodyPart = BodyPart.HEAD;
        } else if (hitCount == 3) {
            hitCount = 0;
            attackedBodyPart = BodyPart.LEG;
        } else if (hitCount == 4) {
            attackedBodyPart = BodyPart.CHEST;
        }
        return attackedBodyPart;
    }

    public BodyPart defend() {
        BodyPart defendedBodyPart = null;
        hitCount = hitCount + 2;

        if (hitCount == 1) {
            defendedBodyPart = BodyPart.HEAD;
        } else if (hitCount == 2) {
            defendedBodyPart = BodyPart.LEG;
        } else if (hitCount == 3) {
            defendedBodyPart = BodyPart.ARM;
        } else if (hitCount == 4) {
            defendedBodyPart = BodyPart.CHEST;
        }
        return defendedBodyPart;
    }
}
