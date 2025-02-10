const brandRepo = require('./brand.repo');
const customResponse = require('../../utils/custom.response');
const { response } = require('express');

const findAll = async (response) => {
    let list = await brandRepo.findAll();
    return customResponse.getOK(response, 200, list);
}

//findById
const findById = async (response, id) => {
    let found = await brandRepo.findById(id);
    return found ? customResponse.getOK(response, 200, found) : customResponse.get404(response); 
}

//save
const save = async (response, brand) => {
    if (brandRepo.save(brand)){
        return customResponse.getOK(response, 201, undefined)
    }else{
        return customResponse.get404(response);
    }
}

//update
const update = async (response, brand) => {
    let found = await brandRepo.findById(brand.id);
    if(!found){
        return customResponse.get404(response);
    }else {
        return await brandRepo.update(brand) ?
        customResponse.getOK(response, 200, undefined) :
        customResponse.get400(response);
    }
}

//delete
const remove = async (response, id) => {
    let found = await brandRepo.findById(id);
    if(!found){
        return customResponse.get404(response);
    }else {
        return await brandRepo.remove(id) ?
        customResponse.getOK(response, 200, undefined) :
        customResponse.get400(response);
    }
}


const brandService = {
    findAll,
    findById, 
    save,
    update,
    remove
}

module.exports = brandService;