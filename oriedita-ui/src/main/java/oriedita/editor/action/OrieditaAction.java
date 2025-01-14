package oriedita.editor.action;

public interface OrieditaAction extends javax.swing.Action {
    default ActionType getActionType() {
        ActionHandler annotation = getClass().getAnnotation(ActionHandler.class);

        if (annotation == null){
            throw new IllegalStateException("Action does not have an @ActionHandler annotation: " + getClass());
        }

        return annotation.value();
    }

    default boolean resetLineStep() {
        return true;
    }
}
