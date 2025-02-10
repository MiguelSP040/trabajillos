const categoryRepo = require('./category.repo');
const customResponse = require('../../utils/custom.response');
const { response } = require('express');

const findAll = async (response) => {
    let list = await categoryRepo.findAll();
    return customResponse.getOK(response, 200, list);
}

//findById
const findById = async (response, id) => {
    let found = await categoryRepo.findById(id);
    return found ? customResponse.getOK(response, 200, found) : customResponse.get404(response); 
}

//save
const save = async (response, category) => {
    if (categoryRepo.save(category)){
        return customResponse.getOK(response, 201, undefined)
    }else{
        return customResponse.get404(response);
    }
}

//update
const update = async (response, category) => {
    let found = await categoryRepo.findById(category.id);
    if(!found){
        return customResponse.get404(response);
    }else {
        return await categoryRepo.update(category) ?
        customResponse.getOK(response, 200, undefined) :
        customResponse.get400(response);
    }
}

//delete
const remove = async (response, id) => {
    let found = await categoryRepo.findById(id);
    if(!found){
        return customResponse.get404(response);
    }else {
        return await categoryRepo.remove(id) ?
        customResponse.getOK(response, 200, undefined) :
        customResponse.get400(response);
    }
}


const categoryService = {
    findAll,
    findById, 
    save,
    update,
    remove
}

module.exports = categoryService;