package listeners;


import com.sun.scenario.effect.Offset;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.events.role.update.RoleUpdatePermissionsEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class SecurityListener extends ListenerAdapter {


    @Override
    public void onRoleUpdatePermissions(RoleUpdatePermissionsEvent event) {

        if (event.getNewPermissions().get(0) == Permission.ADMINISTRATOR) {
            if (event.getRole().getName() == "GLOBALPERMISSIONS") {
                if (event.getNewPermissions().get(0).getRawValue() == Permission.getRaw(Permission.ADMINISTRATOR))
                //event.getJDA().getRolesByName(" ", true).get(0).getManager().givePermissions(Permission.ADMINISTRATOR);
                event.getJDA().getTextChannels().get(0).sendMessage("test loool").queue();
            }
        }

    }

}
