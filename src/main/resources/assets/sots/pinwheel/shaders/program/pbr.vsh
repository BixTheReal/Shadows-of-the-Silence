#version 150

layout(location = 0) in vec3 Position;
layout(location = 2) in vec2 UV0;

out vec2 texCoord0;

uniform mat4 ModelViewMat;
uniform mat4 ProjMat;
uniform vec3 ChunkOffset;


const float TEXTURE_WIDTH = 2048.0;
const float TEXTURE_HEIGHT = 2048.0;


const float ATLAS_WIDTH = 16384.0;
const float ATLAS_HEIGHT = 16384.0;

void main() {
    vec3 pos = Position + ChunkOffset;
    gl_Position = ProjMat * ModelViewMat * vec4(pos, 1.0);
    texCoord0 = UV0 * vec2(ATLAS_WIDTH / TEXTURE_WIDTH, ATLAS_HEIGHT / TEXTURE_HEIGHT);
}
