package day.gitlab.dolphin.common.business.controller;

import day.gitlab.dolphin.common.business.i18n.MessagesHelper;
import io.github.linpeilie.Converter;
import jakarta.annotation.Resource;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
@NoArgsConstructor
public abstract class BaseController {

    @Resource
    protected MessagesHelper messagesHelper;

    @Resource
    protected Converter converter;
}
