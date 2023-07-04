package com.example.appbackend.snapshot.mapping;

import com.example.appbackend.shared.mapping.EnhancedModelMapper;
import com.example.appbackend.snapshot.domain.model.Snapshot;
import com.example.appbackend.snapshot.resource.CreateSnapshotResource;
import com.example.appbackend.snapshot.resource.SnapshotResource;
import com.example.appbackend.snapshot.resource.UpdateSnapshotResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

@Component
@EnableAutoConfiguration
public class SnapshotMapper implements Serializable {


    @Autowired
    EnhancedModelMapper mapper;

    public SnapshotResource toResource(Snapshot model){
        return mapper.map(model, SnapshotResource.class);
    }


    public Page<SnapshotResource> modelListPage(List<Snapshot> modelList, Pageable pageable){
        return new PageImpl<>(mapper.mapList(modelList,SnapshotResource.class),pageable,modelList.size());
    }

    public List<SnapshotResource> modelList(List<Snapshot> modelList){
        return mapper.mapList(modelList,SnapshotResource.class);
    }


    public Snapshot toModel(CreateSnapshotResource resource){
        return mapper.map(resource,Snapshot.class);

    }

    public Snapshot toModel(UpdateSnapshotResource resource){
        return mapper.map(resource,Snapshot.class);
    }


}
