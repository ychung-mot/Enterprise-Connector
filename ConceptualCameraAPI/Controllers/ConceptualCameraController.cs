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
        [HttpGet("cameras")]
        public async Task<ActionResult> GetCameras(int id)
        {
            return Ok(await _cameraServices.GetCamerasAsync());
        }

        // GET: v1/Camera/{id}
        [HttpGet("camera/{id}")]
        public async Task<ActionResult> GetCamera(int id)
        {
            return Ok(await _cameraServices.GetCameraDetailsAsync(id));
        }

        // GET: MOTICamera/Camera/{id}/Image
        [HttpGet("camera/{id}/image")]
        public async Task<ActionResult> GetCameraImage(int id, [FromQuery] string ResponseParameters = "")
        {
            return Ok(await _cameraServices.GetCameraImageAsync(id, ResponseParameters));
        }

        // GET: MOTICamera/Camera/{id}/Image
        [HttpGet("camera/{id}/images")]
        public async Task<ActionResult> GetCameraImages(int id, [FromQuery] DateTime? Start = null, [FromQuery] DateTime? End = null, [FromQuery] string MetadataParameters ="", [FromQuery] string ResponseParameters = "")
        {
            return Ok(await _cameraServices.GetCameraImagesAsync(id, Start ?? DateTime.Now, End ?? DateTime.Now - TimeSpan.FromDays(-1), MetadataParameters, ResponseParameters));
        }

        // GET: MOTICamera/Camera/{id}/Video
        [HttpGet("camera/{id}/video")]
        public async Task<ActionResult> GetCameraVideo(int id)
        {
            return await Task<ActionResult>.FromResult(Ok("Information about the camera video stream"));
        }
    }
}
