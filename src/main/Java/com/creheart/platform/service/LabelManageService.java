package com.creheart.platform.service;

import com.creheart.domain.BelLabel;
import com.creheart.platform.repository.LabelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *
 * Created by sunny-chen on 2017/5/30.
 */
@Component
public class LabelManageService {

    @Autowired
    private LabelRepository labelRepository;

    public List<BelLabel> allLabelList() throws Exception {
        return labelRepository.getAllLabels();
    }

    public BelLabel getLabel(int id) throws Exception {
        return labelRepository.queryLabelById(id);
    }

    public BelLabel getLabel(String labelName) throws Exception {
        return labelRepository.queryLabelByLabelName(labelName);
    }

    public int createLabel(String labelName, String description, String iconUrl) throws Exception {
        BelLabel label = new BelLabel(labelName, iconUrl, description);
        return labelRepository.saveBelLabel(label);
    }

    public void deleteLabel(int id) throws Exception {
        labelRepository.deletBellabel(id);
    }

    public int updateLabel(BelLabel belLabel) throws Exception {
        return labelRepository.update(belLabel);
    }
}
