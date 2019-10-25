package com.remotenashws.controller

import com.remotenashws.model.LaboratorioModel
import com.remotenashws.repository.LaboratorioRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("laboratorio")
class LaboratorioController {

    @Autowired
    lateinit var laboratorioRepository: LaboratorioRepository

    @GetMapping
    fun listLab(): List<LaboratorioModel> {
        return laboratorioRepository.findAll().toList()
    }

    @PostMapping
    fun adicionarLab(@RequestBody laboratorioModel: LaboratorioModel): LaboratorioModel {
        return laboratorioRepository.save(laboratorioModel)
    }

    @PutMapping("{id}")
    fun atualizarLab(@PathVariable id: Long, @RequestBody laboratorioModel: LaboratorioModel): LaboratorioModel {
        if(laboratorioRepository.existsById(id)){
            val safeLab = laboratorioModel.copy(id)
            return laboratorioRepository.save(safeLab)
        }
        return laboratorioModel
    }

    @DeleteMapping("delete/{id}")
    fun deletarLab(@PathVariable id: Long) {
        if(laboratorioRepository.existsById(id)){
            laboratorioRepository.deleteById(id)
        }
    }

}