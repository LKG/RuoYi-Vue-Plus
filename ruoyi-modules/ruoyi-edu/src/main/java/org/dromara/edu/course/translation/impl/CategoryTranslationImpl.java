package org.dromara.edu.course.translation.impl;

import lombok.AllArgsConstructor;
import org.dromara.common.translation.annotation.TranslationType;
import org.dromara.common.translation.core.TranslationInterface;
import org.dromara.edu.course.service.ICategoryService;

/**
 * 分类翻译实现
 *
 * @author Lion Li
 */
@AllArgsConstructor
@TranslationType(type = "category_id_to_name")
public class CategoryTranslationImpl implements TranslationInterface<String> {

    private final ICategoryService categoryService;
    @Override
    public String translation(Object key, String other) {
        if (key instanceof Long id) {
            return categoryService.selectNameById(id);
        }
        return null;
    }
}
