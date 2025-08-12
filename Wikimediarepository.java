package net.aryaman.springboot.repository;

import net.aryaman.springboot.entity.wikimediadata;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Wikimediarepository extends JpaRepository<wikimediadata, Long> {
}
