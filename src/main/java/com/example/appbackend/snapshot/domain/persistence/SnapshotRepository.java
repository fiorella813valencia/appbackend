package com.example.appbackend.snapshot.domain.persistence;


import com.example.appbackend.snapshot.domain.model.Snapshot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SnapshotRepository extends JpaRepository<Snapshot,Long> {
    List<Snapshot> findAll();
    Snapshot findBySnapshotId(String snapshotId);

    List<Snapshot> findByProductSerialNumber(String productSerialNumber);
}
