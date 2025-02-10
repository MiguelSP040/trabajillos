const router = require('express').Router();
const { response } = require('express');
const categoryService = require('./category.service');

router.get('', async (request, response) => {
    response = await categoryService.findAll(response);
});

//findById
router.get('/:id', async(request, response) => {
    let {id} = request.params;
    response = await categoryService.findById(response, id);
});

//save
router.post('', async(request, response) => {
    let {name} =  request.body;
    let category = {name};

    response = await categoryService.save(response, category);
});

//update
router.put('', async (request, response) => {
    let {id, name} = request.body;
    let category = {id, name};

    response = await categoryService.update(response, category);
})

//delete
router.delete('/:id', async (request, response) => {
    let {id} = request.params;
    response = await categoryService.remove(response, id);
});

module.exports = router;