package baritone.bot.pathing.movement.movements;

import baritone.bot.InputOverrideHandler;
import baritone.bot.pathing.movement.Movement;
import baritone.bot.pathing.movement.MovementState;
import baritone.bot.utils.ToolSet;
import net.minecraft.util.math.BlockPos;

public class MovementAscend extends Movement {

    public MovementAscend(BlockPos src, BlockPos dest) {
        super(src, dest);
    }

    @Override
    public double calculateCost(ToolSet ts) {
        throw new UnsupportedOperationException();
    }

    //my suggestion: public MovementAscend(BlockPos src, BlockPos dest){
    // super(src, dest, new BlockPos[]{dest, src.up(2), dest.up()}, new BlockPos[]{dest.down()});
    // This basically says that dest, src.up3 and dest.up need to be passable before this movement can start
    // and that dest.down needs to be stand-on-able

    @Override
    public MovementState calcState() {
        MovementState latestState = currentState.setInput(InputOverrideHandler.Input.JUMP, true).setInput(InputOverrideHandler.Input.MOVE_FORWARD, true);
        if (playerFeet().equals(dest))
            latestState.setStatus(MovementState.MovementStatus.SUCCESS);
        return latestState;
    }

}
