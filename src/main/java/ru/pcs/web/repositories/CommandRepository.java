package ru.pcs.web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.pcs.web.models.Command;

public interface CommandRepository extends JpaRepository<Command, Integer> {
}
