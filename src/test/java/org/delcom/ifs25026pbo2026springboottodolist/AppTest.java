package org.delcom.ifs25026pbo2026springboottodolist;

import org.delcom.ifs25026pbo2026springboottodolist.adapter.presenter.TodoPresenter;
import org.delcom.ifs25026pbo2026springboottodolist.domain.repository.ITodoRepository;
import org.delcom.ifs25026pbo2026springboottodolist.usecase.TodoUseCase;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mockStatic;

@SpringBootTest
class AppTest {

    @Autowired
    private ITodoRepository todoRepository;

    @Autowired
    private TodoUseCase todoUseCase;

    @Autowired
    private TodoPresenter todoPresenter;

    @Test
    void contextLoadsAndCleanArchitectureWiringIsComplete() {
        assertNotNull(todoRepository);
        assertNotNull(todoUseCase);
        assertNotNull(todoPresenter);
    }

    @Test
    void appMainDelegatesToSpringApplicationRun() throws Exception {
        try (MockedStatic<SpringApplication> mocked = mockStatic(SpringApplication.class)) {
            App.main(new String[0]);
            mocked.verify(() -> SpringApplication.run(eq(App.class), any(String[].class)));
        }
    }
}
