package edu.library.controller;


import edu.library.entity.Reader;
import edu.library.entity.Type;
import edu.library.service.TypeService;
import edu.library.util.ResultCode;
import edu.library.util.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/type")
public class TypeController {
    @Autowired
    private TypeService typeService;
    @GetMapping("/list")
    public ResultVO showForm() {
        List<Type> types=typeService.gettypes();
        return  new ResultVO(ResultCode.SUCCESS,types);
    }

    @PostMapping("/list")
    public ResultVO addReader(@RequestBody @Valid Type type) {
        typeService.addType(type);
        return new ResultVO(ResultCode.SUCCESS, null);
    }

    @DeleteMapping("/list/{tid}")
    public ResultVO deleteReader(@PathVariable Integer tid) {
        typeService.deleteById(tid);
        return new ResultVO(ResultCode.SUCCESS, null);
    }
}
