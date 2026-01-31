package com.devease.actions;

import com.intellij.openapi.actionSystem.*;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.SelectionModel;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import org.jetbrains.annotations.NotNull;

public class ExplainErrorAction extends AnAction {

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {

        // Get current editor and project
        Editor editor = e.getRequiredData(CommonDataKeys.EDITOR);
        Project project = e.getProject();

        // Get selected text
        SelectionModel selectionModel = editor.getSelectionModel();
        String selectedText = selectionModel.getSelectedText();

        if (selectedText == null || selectedText.isEmpty()) {
            Messages.showWarningDialog(
                    project,
                    "Please select an error message or code first.",
                    "DevEase"
            );
            return;
        }

        // TEMP: Just show selected text
        Messages.showInfoMessage(
                project,
                selectedText,
                "Selected Text"
        );
    }
}
