const router = require('express').Router();
const { response } = require('express');
const brandService = require('./brand.service');

router.get('', async (request, response) => {
    response = await brandService.findAll(response);
});

//findById
router.get('/:id', async(request, response) => {
    let {id} = request.params;
    response = await brandService.findById(response, id);
});

//save
router.post('', async(request, response) => {
    let {name} =  request.body;
    let brand = {name};

    response = await brandService.save(response, brand);
});

//update
router.put('', async (request, response) => {
    let {id, name} = request.body;
    let brand = {id, name};

    response = await brandService.update(response, brand);
})

//delete
router.delete('/:id', async (request, response) => {
    let {id} = request.params;
    response = await brandService.remove(response, id);
});

module.exports = router;