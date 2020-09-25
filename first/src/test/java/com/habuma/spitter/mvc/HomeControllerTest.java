package com.habuma.spitter.mvc;

import com.habuma.spitter.domain.Spittle;
import com.habuma.spitter.service.SpitterService;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class HomeControllerTest {
    @Test
    public void shouldDisplayRecentSpittles() {
        List<Spittle> expectedSpitles = Arrays.asList(new Spittle(), new Spittle(), new Spittle());

        // Фиктивный объект SpitterService
        SpitterService spitterService = Mockito.mock(SpitterService.class);

        Mockito.when(
                spitterService.getRecentSpittles(HomeController.DEFAULT_SPITTLES_PER_PAGE))
                .thenReturn(expectedSpitles);

        // Создать контроллер
        HomeController controller = new HomeController(spitterService);

        HashMap<String, Object> model = new HashMap<String, Object>();

        // Вызвать обработчик
        String viewName = controller.showHomePage(model);

        Assert.assertEquals("home", viewName);

        // Проверить результаты
        Assert.assertSame(expectedSpitles, model.get("spittles"));
        Mockito.verify(spitterService).getRecentSpittles(HomeController.DEFAULT_SPITTLES_PER_PAGE);
    }
}