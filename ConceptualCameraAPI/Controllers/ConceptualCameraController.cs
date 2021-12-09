using Microsoft.AspNetCore.Mvc;
using Microsoft.Extensions.Logging;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using ConceptualCameraAPI.Services;

namespace ConceptualCameraAPI.Controllers
{
    [Produces("application/json")]
    [ApiController]
    [Route("v1")]
    public class ConceptualCameraController : ControllerBase
    {

        private readonly ILogger<ConceptualCameraController> _logger;
        private readonly ICameraServices _cameraServices;

        public ConceptualCameraController(ILogger<ConceptualCameraController> logger, ICameraServices cameraServices)
        {
            _logger = logger;
            _cameraServices = cameraServices;
        }

        // GET: v1/ping
        [HttpGet("ping")]
        public async Task<ActionResult> GetPing()
        {
            return await Task<ActionResult>.FromResult(Ok("pong"));
        }

        // GET: v1/Cameras
        [HttpGet("Cameras")]
        public async Task<ActionResult> GetCameras(int id)
        {
            return Ok(await _cameraServices.GetCamerasAsync());
        }

        // GET: v1/Camera/{id}
        [HttpGet("Camera/{id}")]
        public async Task<ActionResult> GetCamera(int id)
        {
            return Ok(await _cameraServices.GetCameraDetailsAsync(id));
        }

        // GET: MOTICamera/Camera/{id}/Image
        [HttpGet("Camera/{id}/Image")]
        public async Task<ActionResult> GetCameraImage(int id)
        {
            return await Task<ActionResult>.FromResult(Ok("Information about the image from a camera + image"));
        }

        // GET: MOTICamera/Camera/{id}/Video
        [HttpGet("Camera/{id}/Video")]
        public async Task<ActionResult> GetCameraVideo(int id)
        {
            return await Task<ActionResult>.FromResult(Ok("Information about the camera video stream"));
        }
    }
}
