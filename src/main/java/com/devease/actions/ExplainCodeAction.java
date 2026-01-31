package com.devease.actions;

import com.intellij.openapi.actionSystem.*;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import org.jetbrains.annotations.NotNull;

public class ExplainCodeAction extends AnAction {

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {

        Editor editor = e.getRequiredData(CommonDataKeys.EDITOR);
        Project project = e.getProject();

        String selectedText = editor.getSelectionModel().getSelectedText();

        if (selectedText == null || selectedText.isEmpty()) {
            Messages.showWarningDialog(
                    project,
                    "Please select some code to explain.",
                    "DevEase"
            );
            return;
        }

        Messages.showInfoMessage(
                project,
                "Explain this code:\n\n" + selectedText,
                "DevEase"
        );
    }
}
