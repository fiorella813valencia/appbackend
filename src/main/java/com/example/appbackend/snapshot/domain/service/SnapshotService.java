package com.example.appbackend.snapshot.domain.service;

import com.example.appbackend.product.domain.model.Product;
import com.example.appbackend.snapshot.domain.model.Snapshot;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SnapshotService {

    List<Snapshot> getAll();
    Snapshot getById(Long snapshotId);
//    Snapshot create(Snapshot snapshot,Long productId);
    Snapshot create(Snapshot snapshot);
    Snapshot update(Long snapshotId,Snapshot request);
    ResponseEntity<?> delete(Long snapshotId);

    List<Snapshot> getSnapshotsByProductId(Long productId);
}
