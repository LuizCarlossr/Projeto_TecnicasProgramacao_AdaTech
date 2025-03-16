package br.com.ada.t1322.tecnicasprogramacao.projeto.service;

import br.com.ada.t1322.tecnicasprogramacao.projeto.repository.TaskRepository;
import br.com.ada.t1322.tecnicasprogramacao.projeto.repository.TaskRepositoryImpl;
import br.com.ada.t1322.tecnicasprogramacao.projeto.service.validation.DeadlineValidation;
import br.com.ada.t1322.tecnicasprogramacao.projeto.service.validation.StatusValidation;
import br.com.ada.t1322.tecnicasprogramacao.projeto.service.validation.TaskValidator;
import br.com.ada.t1322.tecnicasprogramacao.projeto.service.validation.TitleValidation;

import java.util.List;

public class TaskServiceFactory {

    public static TaskService createTaskService() {
        TaskRepository repository = TaskRepositoryImpl.getInstance();

        TaskValidator validator = new TaskValidator(List.of(
                new TitleValidation(),
                new DeadlineValidation(),
                new StatusValidation()
        ));

        return TaskServiceImpl.create(repository, validator);
    }
}
