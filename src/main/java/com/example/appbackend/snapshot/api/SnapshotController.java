package com.example.appbackend.snapshot.api;

import com.example.appbackend.product.domain.service.ProductService;
import com.example.appbackend.product.mapping.ProductMapper;
import com.example.appbackend.product.resource.CreateProductResource;
import com.example.appbackend.product.resource.ProductResource;
import com.example.appbackend.snapshot.domain.model.Snapshot;
import com.example.appbackend.snapshot.domain.service.SnapshotService;
import com.example.appbackend.snapshot.mapping.SnapshotMapper;
import com.example.appbackend.snapshot.resource.CreateSnapshotResource;
import com.example.appbackend.snapshot.resource.SnapshotResource;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@Validated
@RestController
@RequestMapping("/api/v1/products/{productId}/snapshots")
public class SnapshotController {
    public final SnapshotService snapshotService;
    private final SnapshotMapper mapper;

    public SnapshotController(SnapshotService snapshotService, SnapshotMapper mapper){
        this.snapshotService=snapshotService;
        this.mapper=mapper;
    }


    //GET ALL
    @GetMapping
    public List<SnapshotResource> getAllSnapshot(@PathVariable Long productId){
        List<Snapshot> snapshots = snapshotService.getSnapshotsByProductId(productId);
        return mapper.modelList(snapshots);
        //return mapper.modelList(snapshotService.getAll());
    }
//    //GET BY ID OJO
//    @GetMapping("{snapshotId}")
//    public SnapshotResource getSnapshotById(@PathVariable Long snapshotId, @PathVariable String productId){
//        return mapper.toResource(snapshotService.getById(snapshotId));
//    }
    //POST
    @PostMapping
    public SnapshotResource createSnapshot(@RequestBody CreateSnapshotResource resource, @PathVariable String productId){
        return mapper.toResource(snapshotService.create(mapper.toModel(resource)));
    }
}
