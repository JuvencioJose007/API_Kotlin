package com.remotenashws.repository

import com.remotenashws.model.LaboratorioModel
import org.springframework.data.repository.CrudRepository

interface LaboratorioRepository : CrudRepository<LaboratorioModel, Long> {
}